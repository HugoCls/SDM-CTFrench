# Crypto 2

## Introduction
Upon clicking on the button Crypto 2, we are redirected on a page with an partially encrypted flag and instructions:

The flag is CTFrench{EvyDehpqckyicovgvGtdbzi}
Watch out, the flag is case sensible

There is also a meme on the page representing the fact that a lot of ctf solver (at least in france) tends to use www.dcode.fr/en to solve or find which crypto cipher is used.
## Walkthrough
To solve this, we can use as the meme mentions www.dcode.fr/en to identify the cipher which is the Vigenere cipher (a french cryptograph)
But the mentionned website does not include the possibility to maintain the case of the decrypted password.

For this we need either to find another website or to be careful in reading the encrypted password and reusing the same case.
After cracking the cipher, we have the flag.

Another way is to look in the metadata of the meme image and there is an hint about the keyword which is LOUVRE.
We can use this to decrypt the flag.

Flag: **CTFrench{TheIndecipherableCipher}**
