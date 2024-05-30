from http.server import BaseHTTPRequestHandler, HTTPServer
from urllib.parse import urlparse, parse_qs

class MyHTTPRequestHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        parsed_path = urlparse(self.path)
        query_params = parse_qs(parsed_path.query)

        if parsed_path.path == '/flag' and 'param' in query_params:

            flag_sentence = query_params['param'][0]

            if 'you_deserve_it' in flag_sentence:
                self.send_response(200)
                self.send_header('Access-Control-Allow-Origin', 'http://79.137.38.217') 
                self.send_header('Content-type', 'text/plain')
                self.end_headers()
                self.wfile.write(b'CTFrench{Coff33_Cr0issant_Cl0pes}')
            else:
                self.send_response(403)
                self.send_header('Access-Control-Allow-Origin', 'http://79.137.38.217') 
                self.send_header('Content-type', 'text/plain')
                self.end_headers()
                self.wfile.write(b'Forbidden')
        else:
            self.send_response(404)
            self.send_header('Access-Control-Allow-Origin', 'http://79.137.38.217')
            self.send_header('Content-type', 'text/plain')
            self.end_headers()
            self.wfile.write(b'Not Found')

def run_server():
    server_address = ('', 5002)
    httpd = HTTPServer(server_address, MyHTTPRequestHandler)
    print('Server running at http://localhost:5002/')
    httpd.serve_forever()

if __name__ == '__main__':
    run_server()
