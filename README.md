[![Build](https://github.com/dmfs/semver/actions/workflows/main.yml/badge.svg?label=main)](https://github.com/dmfs/semver/actions/workflows/main.yml)  
[![codecov](https://codecov.io/gh/dmfs/semver/branch/main/graph/badge.svg?token=2vzHFiHKGk)](https://codecov.io/gh/dmfs/semver)  
[![Confidence](https://img.shields.io/badge/Tested_with-Confidence-800000?labelColor=white)](https://saynotobugs.org/confidence)

# semver

Another [Semantic Versioning 2.0.0](https://semver.org/spec/v2.0.0.html) implementation for Java.

## TODOs

* implement lax parser
* validate pre-release & build identifiers

## Usage

### Create a version from scratch

```java
Version version = new Release(1,0,0); // creates 1.0.0
```

### Version math

Given a current version `v`, new versions are derived by
applying a decorator. The following matrix show the result of
each decorator for a given version (click the links on the decorators for more examples).

| Decorator                                                                                                               | 1.0.0       | 1.1.0       | 1.0.1       | 2.0.0-beta.1 | 1.1.0-beta.1 | 1.0.1-beta.1 |
|-------------------------------------------------------------------------------------------------------------------------|-------------|-------------|-------------|--------------|--------------|--------------|
| [`new NextMajor(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/NextMajor.java)             | 2.0.0       | 2.0.0       | 2.0.0       | 2.0.0        | 2.0.0        | 2.0.0        |
| [`new NextMinor(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/NextMinor.java)             | 1.1.0       | 1.2.0       | 1.1.0       | 2.0.0        | 1.1.0        | 1.1.0        |
| [`new NextPatch(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/NextPatch.java)             | 1.0.1       | 1.1.1       | 1.0.2       | 2.0.0        | 1.1.0        | 1.0.1        |
| [`new MajorPreRelease(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/MajorPreRelease.java) | 2.0.0-alpha | 2.0.0-alpha | 2.0.0-alpha | 3.0.0-alpha  | 2.0.0-alpha  | 2.0.0-alpha  |
| [`new MinorPreRelease(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/MinorPreRelease.java) | 1.1.0-alpha | 1.2.0-alpha | 1.1.0-alpha | 2.1.0-alpha  | 1.2.0-alpha  | 1.1.0-alpha  |
| [`new PatchPreRelease(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/PatchPreRelease.java) | 1.0.1-alpha | 1.1.1-alpha | 1.0.2-alpha | 2.0.1-alpha  | 1.1.1-alpha  | 1.0.2-alpha  |
| [`new NextPreRelease(v)`](https://github.com/dmfs/semver/blob/main/src/main/java/org/dmfs/semver/NextPreRelease.java)   | 1.1.0-alpha | 1.2.0-alpha | 1.1.0-alpha | 2.0.0-beta.2 | 1.1.0-beta.2 | 1.0.1-beta.2 |
| `new MajorPreRelease(v, "beta")`                                                                                        | 2.0.0-beta  | 2.0.0-beta  | 2.0.0-beta  | 2.0.0-beta.2 | 2.0.0-beta   | 2.0.0-beta   |
| `new MinorPreRelease(v, "beta")`                                                                                        | 1.1.0-beta  | 1.2.0-beta  | 1.1.0-beta  | 2.0.0-beta.2 | 1.1.0-beta.2 | 1.1.0-beta.1 |
| `new PatchPreRelease(v, "beta")`                                                                                        | 1.0.1-beta  | 1.1.1-beta  | 1.0.2-beta  | 2.0.0-beta.2 | 1.1.0-beta.2 | 1.0.1-beta.2 |
| `new NextPreRelease(v, "beta")`                                                                                         | 1.1.0-beta  | 1.2.0-beta  | 1.1.0-beta  | 2.0.0-beta.2 | 1.1.0-beta.2 | 1.0.1-beta.2 |

Note, that some of these decorators exist in other variants
with slightly different behavior. The Matrix shows the most common ones.

Also note, `NextPreRelease` increases the pre-release version if there is one and creates a pre-release for the next
minor version otherwise.

### Conversion to CharSequence/String

The `Version` implementations do only a single thing, represent a version. To get a `CharSequence`
representation you use a dedicated adapter class called `VersionSequence`, on which you can call `toString()` if you
need a `String`

```java
CharSequence ver = new VersionSequence(version);
String verString = new VersionSequence(version).toString();
```

## License

Copyright 2023 dmfs GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

