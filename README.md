# net.oneread.numtotextru
This is a small library that will translate integer numbers into its string representation in Russian language.

To use simply copy the .arr file into lib folder and include:

````allprojects {
    repositories {
        jcenter()
        flatDir {
            dirs 'libs'
        }
    }
}````

and 

````compile(name:'net.oneread.surfstudio.test.numtotext', ext:'aar')````
