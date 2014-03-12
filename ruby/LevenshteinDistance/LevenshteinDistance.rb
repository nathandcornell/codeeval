#!/usr/bin/ruby

invalidFileMsg = "Invalid filename."

file = ARGV[0]

abort(invalidFileMsg) if file.nil? || file.empty? || !File.exist?(file);

File.open(file).each do |line|
    next if line.chomp.nil? || line.chomp.empty?


end
