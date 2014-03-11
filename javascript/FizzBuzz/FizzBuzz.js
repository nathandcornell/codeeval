var file = process.argv[2];
var fileSystem = require("fs");

var fizz = "F";
var buzz = "B";

if (file == null || file.length < 1) { process.exit(1); }

fileSystem.exists(file, function(exists) {
    if (!exists) { process.exit(1); }
});

var argumentLines = new Array();

fileSystem.readFileSync(file).toString().split('\n').forEach(function (line) {
    argumentLines.push(line);
});

for ( i = 0; i < argumentLines.length; i++ ) {
    if ( argumentLines[i].length < 1 ) continue;

    argumentArray = argumentLines[i].split(" ");

    if ( argumentArray.length < 3 ) continue;

    var fizzNumber = parseInt(argumentArray[0]);
    var buzzNumber = parseInt(argumentArray[1]);
    var maxNumber  = parseInt(argumentArray[2]);

    var message = "";

    for ( j = 1; j <= maxNumber; j++ ) {
        var messageChunk = "";

        if ( j % fizzNumber == 0 ) { messageChunk += fizz; }
        if ( j % buzzNumber == 0 ) { messageChunk += buzz; }
        if ( messageChunk.length == 0 ) { messageChunk = j.toString(); }

        messageChunk += ( j <= maxNumber ) ? " " : "\n";

        message += messageChunk;
    }

    console.log(message);
}
