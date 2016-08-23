var page = require('webpage').create();
page.onConsoleMessage = function(msg) {
  console.log('Page title is ' + msg);
};
page.open("http://www.lolofinil.com", function(status) {
  page.evaluate(function() {
    console.log(document.title);
  });
  phantom.exit();
});