# DSA Problems in Java

Code from [@dsa.java.hub](https://instagram.com/dsa.java.hub) — Java & DSA, explained simply.

## What's in here

| Folder | Topic |
|---|---|
| `arrays/` | Array basics, 2D arrays & matrix traversal |
| `searching/` | Linear & binary search |
| `strings/` | String immutability |
| `quicktips/` | Short, focused tips (e.g. Array vs ArrayList) |
| `bugspots/` | Intentionally buggy code — try to spot the bug before checking the fix |

## How to run

No build tool needed — just plain `javac`/`java`, from this repo's root:

​```bash
javac -d . arrays/ArrayBasics.java
java arrays.ArrayBasics
​```

## Contributing / extending

Each folder is its own Java package (matching the folder name exactly). To add a new topic, create a new folder and give each file inside it a matching `package <foldername>;` declaration.