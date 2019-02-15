# Parse .properties, .yml, .json, .xml, .txt from android project

Create a directory under main folder (project view) like - assets/file

See [MainActivity.java](https://github.com/akramul-hasan-m4/Load-file-and-custom-font-in-android/blob/master/app/src/main/java/com/example/loadpropertiesfileandcustomfont/MainActivity.java) and [PropertiesConfig.java](https://github.com/akramul-hasan-m4/Load-file-and-custom-font-in-android/blob/master/app/src/main/java/com/example/loadpropertiesfileandcustomfont/util/PropertiesConfig.java)

**Note :** For parsing .yml file you need to a library - called [snake-yaml](https://github.com/bmoliveira/snake-yaml)

Add build.gradle file (project lavel)

```
allprojects {
	repositories {
	...
	maven { url "https://jitpack.io" }
  }
}
```

Add dependency in build.gradle file (app lavel)

```
dependencies {
	compile 'com.github.bmoliveira:snake-yaml:v1.18-android'
}
```
**Note :** You can also yml as a text file by calling 
```java
String ymlObj = PropertiesConfig.getfromTxtFile(this, "config.yml");
```
# Use Custom Font from Asset and Font folder Or direct Use in Layout File

Create a directory under main folder (project view) like - assets/fonts

**or**

Create a directory under res like - font

**Note :** file name should be lower case (remove special charecter, digit from file name) u can use underscore

see [CustomTextView.java](https://github.com/akramul-hasan-m4/Load-file-and-custom-font-in-android/blob/master/app/src/main/java/com/example/loadpropertiesfileandcustomfont/customView/CustomTextView.java)

You can also direct use from any class see OnCreate method in [MainActivity.java](https://github.com/akramul-hasan-m4/Load-file-and-custom-font-in-android/blob/master/app/src/main/java/com/example/loadpropertiesfileandcustomfont/MainActivity.java) like -

```java
		TextView textview = findViewById(R.id.textView);
        Typeface font = ResourcesCompat.getFont(this, R.font.greatvibes_regular);
        textview. setTypeface(font);
```

Or direct use from layout file see [activity_main.xml](https://github.com/akramul-hasan-m4/Load-file-and-custom-font-in-android/blob/master/app/src/main/res/layout/activity_main.xml) like -

```xml
<TextView
        android:layout_width="match_parent"
        android:text="Direct from font folder"
        android:gravity="center"
        android:textSize="30sp"
        android:layout_marginTop="20dp"
        android:fontFamily="@font/orangejuice"
        android:layout_height="wrap_content" />
```