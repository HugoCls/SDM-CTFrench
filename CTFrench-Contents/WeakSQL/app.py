from flask import Flask, request, render_template, redirect
import mysql.connector
import time

app = Flask(__name__,template_folder='./templates')

# Database Configuration
db_config = {
    'user': 'overcop_user',        # Your MySQL username
    'password': 'Uqo08o_01',        # Your MySQL password
    'host': '79.137.38.217',
    'database': 'ctf'   # Your database name
}

# Route for handling the landing page
@app.route('/')
def index():
    return render_template('index.html')

# Login Route
@app.route('/login', methods=['GET', 'POST'])
def login():
    msg=''
    print(request.form)
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']

        conn = mysql.connector.connect(**db_config)
        cursor = conn.cursor(dictionary=True)
        query ="SELECT * FROM users WHERE username= '"+username+"' AND password= '"+password+"' ;"
        print(query)
        cursor.execute(query)
        user = cursor.fetchall()
        print(user)
        cursor.close()
        conn.close()

        if user:
            return redirect('/search')
        else:
            # Invalid credentials
            print("Invalid Credentials")
            return render_template('login.html',msg='Login Failed, Invalid Credentials !!')

    return render_template('login.html',msg=msg)


@app.route('/search', methods=['GET', 'POST'])
def search():
    users = []
    print(request.form)
    if request.method == 'POST':
        username_search = request.form['username']

        conn = mysql.connector.connect(**db_config)
        cursor = conn.cursor(dictionary=True)

        query = "SELECT * FROM users WHERE username LIKE '%"+username_search+"%';"
        print(query)

        cursor.execute(query)

        users = cursor.fetchall()

        cursor.close()
        conn.close()


    return render_template('search.html', users=users)

if __name__ == '__main__':
    app.run(debug=True)
