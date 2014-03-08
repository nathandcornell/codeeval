<?php
/**
 * FizzBuzz reads a user-supplied file and uses the three * space delimited integers from each 
 * line to play a game of FizzBuzz.
 * The first argument is used as the first, or "fizz" number.
 * The second argument is used as the second, or "buzz" number.
 * The third argument is used as the maximum number, upon which the game ends.
 *
 * @package FizzBuzz
 * @author Nate Cornell
 * @version 0.1
 */

define('FB_NUMBER', 0);
define('MAX_NUMBER', 1);
define('ARG_RULES', "
    The first two arguments must be between 1 and 20.
    The third number must be between 21 and 100.
");

define('FIZZ', 'F');
define('BUZZ', 'B');

$filename = $argv[1];

if (!$filename) { die(false); }

$fileContents = file($filename);

if (!$fileContents || empty($fileContents)) { die(false); }

foreach ($fileContents as $line) {
    $arguments = explode(' ', $line);

    if (empty($arguments) || count($arguments) < 3) { 
        echo "Line '$line' is not a valid argument line.\n";
        continue; 
    }

    $fizzNumber = (int)$arguments[0];
    $buzzNumber = (int)$arguments[1];
    $max        = (int)$arguments[2];

    if (   !isValid($fizzNumber, FB_NUMBER) 
        || !isValid($buzzNumber, FB_NUMBER) 
        || !isValid($max, MAX_NUMBER)) {

        continue;
    }

    $message = "";

    for ($i = 1; $i <= $max; $i++) {

        $message .= fizzOrBuzz($i, $fizzNumber, $buzzNumber, FIZZ, BUZZ);

        if ($i < $max) { $message .= ' '; }
    }

    echo "$message\n";
}

function isValid($argument, $type) {
    $minimum = ($type == FB_NUMBER) ? 1  : 21;
    $maximum = ($type == FB_NUMBER) ? 20 : 100;

    if ($argument < $minimum || $argument > $maximum) {

        echo "Argument '$argument' is not a valid argument.\n";
        echo ARG_RULES . "\n";

        return false;
    }

    return true;
}

function fizzOrBuzz($candidate, $fizzNumber, $buzzNumber, $fizz, $buzz) {

    $returnString = "";

    if ($candidate % $fizzNumber == 0) { $returnString .= $fizz; }
    if ($candidate % $buzzNumber == 0) { $returnString .= $buzz; }

    if (strlen($returnString) == 0) { return $candidate; }

    return $returnString;
}

?>
