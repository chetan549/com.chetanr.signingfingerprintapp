/*global cordova, module*/

module.exports = {
    getSha1: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Signingfingerprint", "getSha1", [name]);
    }
};
