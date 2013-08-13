OCRErrorStatistics
==================
extraction and counting of OCR errors

following the error classes:

0.10: latin (ignore) 
1.00: correct 
0.99: self correction (~correct) 
0.70: self correction (correct) 
0.98: error (accent) 
0.97: error (?) 
0.96: error (impossible syllabic sequence) 
0.95: error (single bad chars) 
0.94: error (random chars) 
0.90 - 0.71 (del - suggestions): ignore

error rate was counted by error/nonignored. NaN implies that the whole document was ignored and a division 0.00 took place.
