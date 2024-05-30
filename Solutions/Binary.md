# Binary

## Introduction

In this application we can see there are multiple buttons. We can enter a request by writting a single letter and the application return another letter in a "flag".
We need to find the good "flag" to get the real flag.

The flag is CTFrench{Coff33_Cr0issant_Cl0pes}

## Walkthrough

To solve this, we need to look into the Mainactivity file of the app and the Requestlist file to see that when we send a single letter it return another letter with a new alphabet logic.
We can see that we need to get the "flag" you_deserve_it to have the real flag.
When you write the good sentence letter by letter "jkf-ymwmvom-ul" (you should have "you_deserve_it" as "flag") you will see a link appear.
When you enter the link with the param "jkf.ymwmvom.ul" (so the url is "http://79.137.38.217:5002/flag?param=jkf-ymwmvom-ul") you can get the flag.

**CTFrench{Coff33_Cr0issant_Cl0pes}**
