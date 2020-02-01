# Cordova Signingfingerprint Plugin

Simple plugin that returns your signed finger print key string of your ionic or cordova app.

## Using

Create a new Cordova Project

$ cordova create signingfingerprint com.chetanr.signingfingerprintapp Signingfingerprint

Install the plugin

$ cd signingfingerprint
$ cordova plugin add https://github.com/don/cordova-plugin-signingfingerprint.git


Edit `www/js/index.js` and add the following code inside `onDeviceReady`

```js
var success = function(message) {
    alert(message);
}

var failure = function() {
    alert("Error calling Signingfingerprint Plugin");
}

signingfingerprint.getSha1("World", success, failure);
```


Ionic 1

``` in your js file
var success = function(message) {
    alert(message);
}

var failure = function() {
    alert("Error calling Signingfingerprint Plugin");
}

cordova.plugins.signingfingerprint.getSha1("World", success, failure);
```

Ionic 2 or 3

``` in your ts file

declare var signingfingerprint: any; //at top of your file just after import statements

platform.ready().then(() => {

    var success = function(message) {
        alert(message);
    }

    var failure = function() {
        alert("Error calling Signingfingerprint Plugin");
    }

    signingfingerprint.getSha1("World", success, failure);

    });

    ```


    Install iOS or Android platform

    cordova platform add ios
    cordova platform add android

    ## More Info

    For more information on setting up Cordova see [the documentation](http://cordova.apache.org/docs/en/latest/guide/cli/index.html)

    You can contact us at 9818888673 or email us at chetan.bhu1u@gmail.com
