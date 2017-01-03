```
for i from 0 through n - 1
     for r that makes both i - r and i + r in range.
               if charAt(i - r) != charAt(i + r) break;
          count++;

for i from 0 though n - 2
     for r that makes both i - r and i + 1 + r in range
          if charAt(i - r) == charAt(i + 1 + r) break. 
          count++;

return count;
```