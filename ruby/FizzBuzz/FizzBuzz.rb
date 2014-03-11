#!/usr/bin/ruby

invalidFileMsg = "Invalid filename."
fizz = "F"
buzz = "B"

file = ARGV[0]

abort(invalidFileMsg) if file.nil? || file.empty? || !File.exist?(file);

File.open(file).each do |argumentLine|
    next if argumentLine.nil? || argumentLine.empty?

    argumentArray = argumentLine.split

    fizzNumber = argumentArray[0].to_i
    buzzNumber = argumentArray[1].to_i
    maxNumber  = argumentArray[2].to_i

    message = ""

    (1 .. maxNumber).each do |i|

        messageChunk = ""

        messageChunk += fizz.to_s if i % fizzNumber == 0
        messageChunk += buzz.to_s if i % buzzNumber == 0
        messageChunk = i.to_s if messageChunk.empty?

        messageChunk += (i < maxNumber) ? " " : "\n"

        message += messageChunk
    end

    print message
end
