# Microstream with GraalVM native image
This example demonstrates Microstream running in a GraalVM native image.

## Building the example (Windows)
### prerequisites

1. Install the [GraalVM SDK](https://www.graalvm.org/downloads/) for Java 1.8

2. To build GraalVM native images on windows you must install the [Windows 7.1 SDK ](https://www.microsoft.com/en-us/download/details.aspx?id=8442)

If the installation fails because an other .Net runtime ist already installed, continue the SDK installation without the compiler and apply [VC-Compiler-KB2519277.exe](https://www.microsoft.com/de-de/download/details.aspx?id=4422) afterwards to install the compilers.

### Build
1. open a windows SDK 7.1 command prompt
2. Create a fat jar using maven:  
`mvn package`
3. Build the native image:  
`native-image -jar graalvm-native-03.00.00-MS-GA-jar-with-dependencies.jar --no-fallback --verbose --report-unsupported-elements-at-runtime`

### Running
just run graalvm-native-03.00.00-MS-GA-jar-with-dependencies.exe


## building with GraalVM Java 11 SDK
Building a native image with GraalVM for Java 11 currently requires the nightly build GraalVM CE 20.2.0-dev-20200716_0203 or later