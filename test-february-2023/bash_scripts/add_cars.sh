#!/bin/bash

file_path="/home/ubuntu/Documents/geek_brains/java/test-february-2023/Игрушки/Игрушки_для_дошколят/машинки"
id=$(<carsfile)
id=$((id + 1))
toy="машинка"
weight=$(shuf -i 0-100 -n 1)
FLOOR=0
RANGE=100
while [ "$weight" -le $FLOOR ]; do
  weight=$RANDOM
  let "weight %= $RANGE"
done
text_line="Id: ${id} Toy: ${toy} Weight: ${weight}"
echo "${text_line}" >> "${file_path}"
echo "${id}" > carsfile

