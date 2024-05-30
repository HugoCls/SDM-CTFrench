# Crypto 1

## Introduction

In the application, we can see we need a password to get the flag.
In the MainActivity file of the app we can see a sepcial hash is required to get the flag.

The flag is CTFrench {baguette_is_nice}.

## Walkthrough 

To solve this, if you look inside the files of the application in the MainActivity there is an MD5 hash (found in strings.xml), so you can use a website to find out what this hash corresponds to. 
After searching we find that it corresponds to the word ‘baguette’ and by entering this word we obtain the flag.

Flag : **CTFrench{baguette_is_nice}**



