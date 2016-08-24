var page = require('webpage').create();
page.open('http://www.lolofinil.com', function(status) {
  console.log("Status: " + status);
  if(status === "success") {
    page.render('lolofinil.png');
  }
  phantom.exit();
});

