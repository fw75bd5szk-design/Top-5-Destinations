# Top-5-Destinations
A Java slideshow that displays five popular travel destinations with images, descriptions, and Previous and Next navigation buttons.

This project was created for my CS 250 course at Southern New Hampshire University.

## Destinations

1. Grand Canyon
2. Hawaii
3. Miami
4. New York City
5. Orlando

## Features

* Displays an image for each destination
* Includes a short travel description
* Previous and Next navigation buttons
* Uses `CardLayout` to switch between slides
* Keeps the destination image and description synchronized

## Technologies Used

* Java
* Eclipse IDE

## How to Run the Project

1. Download or clone this repository.
2. Open Eclipse.
3. Select **File > Import**.
4. Choose **Existing Projects into Workspace**.
5. Select the downloaded project folder.
6. Open `SlideShow.java` inside the `src` folder.
7. Select **Run As > Java Application**.

## How It Works

The program uses two Java `CardLayout` objects. One controls the destination images, while the other controls the matching descriptions. When the user selects Previous or Next, both layouts change together so the correct image and description remain paired.

## Image Credits

The destination images used in this educational project were obtained from Unsplash. Image-credit information is also included in the comments of the Java source file.

## Author

Daniel Deleon
