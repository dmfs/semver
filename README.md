[![Build Status](https://travis-ci.com/dmfs/semver.svg?branch=main)](https://travis-ci.com/dmfs/semver)
[![codecov](https://codecov.io/gh/dmfs/semver/branch/main/graph/badge.svg?token=2vzHFiHKGk)](https://codecov.io/gh/dmfs/semver)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/dmfs/semver.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/dmfs/semver/context:java)

# semver

Another [Semantic Versioning 2.0.0](https://semver.org/spec/v2.0.0.html) implementation for Java.

## TODOs

* implement lax parser
* validate pre-release & build identifiers

## Usage

### Create a version from scratch

```java
Version version = new StructuredVersion(1,0,0); // creates 1.0.0
```

### Create a new release

Given a current version `version`  a new patch, minor or major release is created with

```java
new NextPatch(version)
new NextMinor(version)
new NextMajor(version)
```

### Create a new pre-release

Given a current version `version`  a new pre-release is created with

```java
new NextPreRelease(version)  // creates a pre-release version that's greater than the given one
new PatchPreRelease(version) // creates a pre-release of the next patch version
new MinorPreRelease(version) // creates a pre-release of the next minor version
new MajorPreRelease(version) // creates a pre-release of the next major version
```

### Conversion to CharSequence/String

The `Version` implementations do only a single thing, represent a version. To get a `CharSequence`
representation you use a dedicated adapter class called `VersionSequence`, on which you can call `toString()` if you need a `String`

```java
CharSequence ver = new VersionSequence(version);
String varString = new VersionSequence(version).toString();
```


## License

Copyright 2021 dmfs GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

