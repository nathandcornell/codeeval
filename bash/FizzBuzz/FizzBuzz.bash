#! /bin/bash

FIZZ='F'
BUZZ='B'

FB_NUMBER=0
MAX_NUMBER=1

FB_MAX=21
FB_MIN=1
COUNT_MAX=100
COUNT_MIN=20

file=$1

if [ ! -e "$file" ] || [ ! -s "$file" ]; then
    print $INVALID_FILE
    exit 1
fi

while read argumentLine; do

    # CodeEval doesn't grok the IFS variable:
    # IFS=' ' read -a arguments <<< "$argumentLine"
    arguments=($argumentLine)

    fizzNumber=${arguments[0]}
    buzzNumber=${arguments[1]}
    maxNumber=${arguments[2]}

    message=""

    startNo=1;

    for i in $(eval echo "{$startNo..$maxNumber}"); do
        messageFragment=''

        if [ $(( $i % $fizzNumber )) -eq 0 ]; then 
            messageFragment="$messageFragment""$FIZZ"
        fi

        if [ $(( $i % $buzzNumber )) -eq 0 ]; then 
            messageFragment="$messageFragment""$BUZZ" 
        fi

        if [ ${#messageFragment} -eq 0 ]; then messageFragment="$i"; fi

        if [ "$i" -lt "$maxNumber" ]; then messageFragment="$messageFragment "; fi

        message="$message""$messageFragment"
    done

    echo "$message"

done < $file
