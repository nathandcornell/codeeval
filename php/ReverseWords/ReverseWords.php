<?php

if ( count($argv) < 2 ) { exit(1); }

$filename = $argv[1];

if (!$filename) { die(false); }

$fileContents = file($filename);

if (!$fileContents || empty($fileContents)) { die(false); }

foreach ($fileContents as $line) {
    $line = trim($line);

    if ( !$line || $line == "") { continue; }

    $lineReversed = reverseLine($line);

    if ( !$lineReversed || $lineReversed == "") { continue; }

    echo $lineReversed . "\n";
}

function reverseLine($line) {
    $words = explode(' ', $line);

    if ( count($words) < 2 ) { return false; }

    $reversedLine = "";

    for ($i = count($words) - 1; $i >= 0; $i--) {
        $reversedLine .= $words[$i];

        if ( $i > 0 ) { $reversedLine .= " "; }
    }

    return $reversedLine;
}

?>
