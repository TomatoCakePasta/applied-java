## Setup
```
// Install Open JDK
% brew install openjdk

// Create a symbolic link to the OpenJDK installed via Homebrew in a location 
// where macOS can recognize it as the default Java
% sudo ln -sfn $(brew --prefix)/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

## Run
```
// Compile
// -d : Specify location of the class folders
% javac -d bin Main.java

// Run
% java -cp bin Main
```