# Maven Multi-Module Performance Tests
This project demonstrates the performance overhead of using multiple modules in Maven compared to a single-module setup.

## Project Structure

The repository includes three Maven projects with a distinct module organization:
* `flat`: A single-module Maven project containing all code in one module.
* `hierarchical`: A project where each Java file resides in its own Maven module. Run `./create.sh` to generate the module structure.
* `multi-hierarchical`: A project divided into 26 Maven modules, each containing 4 sub-modules, plus an additional module that depends on all others. Run `./create.sh` to generate the module structure.

## Performance Results

The following results were obtained by building each project using the specified Maven commands. Tests were conducted on an `AMD Ryzen 7 7700 8-Core Processor (3.80 GHz)` running `Windows 11 Pro 24H2`.

### Command: `./mvnw clean package`

| Project | Build Time (s) | Output Size (bytes) |
| --- | --- | --- |
| flat | 1.607 | 65,528 |
| hierarchical | 10.022 | 155,650 |
| multi-hierarchical | 10.397 | 158,280 |

### Command: `./mvnw clean package -T 1.0C`

| Project | Build Time (s, Wall Clock) | Output Size (bytes) |
| --- | --- | --- |
| flat | 1.637 | 65,528 |
| hierarchical | 4.970 | 155,949 |
| multi-hierarchical | 5.144 | 158,426 |
