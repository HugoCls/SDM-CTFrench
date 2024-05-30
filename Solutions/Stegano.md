# Stegano

## Introduction

The application shows images that scroll when you press the button. 

The flag is CTFrench{a_true_king_s_meal}

## Walkthrough

To solve this, we can see that after clicking a certain number of times, you'll notice that a frog appears in a particular image, along with text telling you to take a closer look at what's in the dish.

So by using tools to see information on this photo like exiftool we find that there's a hidden message telling us that this dish looks like it comes from a town in the south of France.

After searching the original location of the dish, we discovered if comes from Marseille. This leads us to study the image called marseille.png. Again, if we look with exiftool to see details of the image, we see that there's a new message telling us to look at a stegano tool. So by using the stegano-lsb reveal tool we can find the flag hidden in the image.

Flag : **CTFrench{a_true_king_s_meal}**




