# Assignment 3: Music Library App

After manipulating basic widgets, the objective of this assignment is to work with Activities and Intents.
In the previous lecture, we have seen how to create new Activities and how to create Intents to pass information from an Activity to another.

This assignment will also make you work with concepts seen during the previous lectures such as ListViews, RecyclerViews, and reading files.

This assignment requires less implementation than the previous one, but it might take you some time to correctly read and use the information
written in the file that comes with the starter code.

__The deadline for this assignment is Tuesday 16/10/2018, 23:59.__

## Description of the App
This app is similar to your favorite music player application, except that we are not going to play any songs. We will simply
be listing names of artists, albums, and songs.

The starter code provides you with an empty project with only a BandActivity.

Your task will consist in:
- Creating two additional Activities: AlbumActivity and SongActivity
- In the BandActivity, the application should:
  - Read the contents of the CSV file
  - Display the names of the bands in a ListView
  - When the user clicks on an item in the list, AlbumActivity should appear
- In the AlbumActivity, the application should:
  - Read the contents of the CSV file
  - Display in a ListView the names of the albums corresponding to the Band that was clicked on
  - When the user clicks on an item in the list, SongActivity should appear
- In the SongActivity, the application should:
  - Read the contents of the CSV file
  - Display in a ListView the names of the song in the album that the user selected
  
The CSV file contains:
  - A header row that describes the contents of each column
  - A list of bands, albums, and songs
It is located in the res/raw folder.


## Bonus to make the app better
All this section is bonus work. Please make sure that the principal features are implemented correctly before
working on bonuses.
1. Instead of using ListViews, use a RecyclerView
2. Use a custom TextView to display the items of the RecyclerView
3. Instead of reading the contents of the file in every activity, pass the necessary information with Intents