# NetWork-Cache
NetWork Cache event-driven simulator
Authors: Yizhe Wu, Yepeng Liu


1. Library: For random number generation, we use the "commons.math3" library of JAVA. You will need to download the library and install it on your system.

2. Compilation: "main.java" is our main program. A Makeﬁle is provided to compile "main.java". On Linux system,  type ‘make’ to compile the code.

3. Parameters(input): 
(1) totalFilesNumber: N files residing in far away Internet servers.
(2) totalFileSize: sum of all file size.
(3) durationTime: response time, which is the duration from the time of the request till the time the ﬁle is received by the user.
(4) Lambda: file request with rate Lambda per second.
(5) fileNumber[][]: The i-th file <size, probability>.
(6) R_a: In-bound bandwidth [R_a] (constant) /Mbps => MB/s.
(7) R_c: Institution network bandwidth [R_c] (constant) /Mbps => MB/s.
(8) D: Round-trip propagation time [D] (constant) /ms => /s.
(9) C: Cache capacity [C].
(10) RequestTs: Total Request Times /s.

4. Output:
(1) Total request number.
(2) Hit number.
(3) Hit rate.
(4) Average response time.
