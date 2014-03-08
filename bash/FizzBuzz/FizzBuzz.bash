#! /bin/bash

FIZZ='F'
BUZZ='B'

FB_NUMBER=0
MAX_NUMBER=1

FB_MAX=21
FB_MIN=1
COUNT_MAX=100
COUNT_MIN=20

ARGS_ERROR_MSG="\
The fizz and buzz numbers must be between $FB_MIN and $FB_MIN.\
The maximum number must be between $COUNT_MIN and $COUNT_MAX.\
"

INVALID_ARG='Invalid argument: '
INVALID_FILE='Invalid file.'

file=$1

if [ ! -e "$file" ] || [ ! -s "$file" ]; then
    echo $INVALID_FILE
    exit 1
fi

while read argumentLine; do

    IFS=' ' read -a arguments <<< "$argumentLine"

    fizzNumber=${arguments[0]}
    buzzNumber=${arguments[1]}
    maxNumber=${arguments[2]}

    message=""

    startNo=1;

    # For some reasone CodeEval cannot evaluate the range here:
    # for i in $(eval echo "{$startNo..$maxNumber}"); do
    for (( i=$startNo; i<=$maxNumber; i++ )); do
        messageFragment=''

        if [ $( expr "$i" % "$fizzNumber" ) -eq 0 ]; then messageFragment="$messageFragment""$fizz"; fi
        if [ $( expr "$i" % "$buzzNumber" ) -eq 0 ]; then messageFragment="$messageFragment$buzz"; fi
        if [ ${#messageFragment} -eq 0 ]; then messageFragment="$i"; fi

        if [ "$i" -lt "$maxNumber" ]; then messageFragment="$messageFragment "; fi

        message="$message""$messageFragment"
    done

    echo "$message"

done < $file
