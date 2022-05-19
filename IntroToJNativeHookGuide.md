<div id="top"></div>
<!--
*** Definitely just stole this from
*** https://github.com/othneildrew/Best-README-Template/blob/master/README.md
-->

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

I was trying to learn JNativeHook and didn't find many great guides out there going from
simple implementation to full-blown working project.

The official documentation for the "areas" of use found https://github.com/kwhat/jnativehook/tree/2.2/doc is more than enough
for most people, but I like to learn through examples.

The **unofficial** javadoc can be found here https://javadoc.io/doc/com.1stleg/jnativehook/latest/index.html

There are two folders found in the project `/src/` director. The "Introduction" folder will go into the ideas
behind this library we are using. The "ExampleProjects" folder will try to give some simple examples of implementation of the
JNativeHook library.
<p align="right">(<a href="#top">back to top</a>)</p>


### Built With

All of this will be coded in Java 17 and it is using the most up to date release of JNativeHook as of May-19-2022.

This project has a `/libs/` folder with `jnativehook-2.2.2.jar` existing within it. Other information or other releases
can be found on the GitHub page for [JNativeHook](https://github.com/kwhat/jnativehook).

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

Follow these instructions if you want to use this app.

### Prerequisites
**(This onely applies if not using the jar file)**

This application relies on [JNativeHook 2.2.2](https://github.com/kwhat/jnativehook) or newer.
- If you want to use a different version of JNativeHook, they can be found [here](https://github.com/kwhat/jnativehook/releases).
  Download the relevant jar file.

### Installation

This will be confirmed working on Windows machines using IntelliJ (what it's being developed from).
* Run `git clone https://github.com/jasdrive/JavaFX_GUI_AutoClicker.git`
* Open the src folder in IntelliJ.
* On IntelliJ, go file -> Project Structure -> Modules -> Dependencies.
* Directly beneath "Module SDK" select the + icon and find your JNativeHook.jar file.
  * Should be found in `\IntroToJNativeHook\libs`
* Add the file to the dependency list, apply and close.
* You can now compile `src/GUI/RenderGUI`'s main method which will run the program.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage

This is just meant to be an educational document that will potentially help others learn the basics of JNativeHook.

Use it however you see fit, feel free to open issues or submit requests.

<p align="right">(<a href="#top">back to top</a>)</p>
