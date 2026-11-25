# Java runtime assessment

Assessment date: 2026-11-25.

- Runtime: Java, targeting Java 17 in `pom.xml` (compiler plugin source/target and compiler properties). `README.md` also requires Java 17 or higher.
- Latest feature release: Java 27 (non-LTS). Latest LTS: Java 25.
- Status: Supported (LTS), subject to JDK vendor and support entitlement. Oracle JDK 17 Premier Support ended in September 2026; Extended Support runs through September 2029 for entitled customers. Other distributions have their own schedules.
- Recommendation: Plan an upgrade to Java 25 LTS; an immediate major-version upgrade is not required solely because this project targets Java 17. Continue using current security patches from a supported JDK distribution.

## Upgrade checks

1. Verify Java 25 compatibility of the Jetty 9.4.54 JSP stack, Mockito 5.11.0, and Maven plugins declared in `pom.xml`; update incompatible dependencies/plugins before changing the target.
2. Select JDK 25 for development and deployment. Update both compiler configuration locations in `pom.xml` from 17 to 25, or consolidate them into a single compiler release setting. Update Java requirements in `README.md`.
3. Run `mvn clean verify` under JDK 25 and smoke-test `java -jar target\emp-demo-standalone.jar`, including JSP rendering and employee operations.

These are recommended checks, not a claim that Java 25 compatibility has been verified. No runtime or dependency configuration was changed.

## Sources

- Project evidence: `pom.xml`, `README.md`.
- Latest releases: https://www.oracle.com/java/technologies/downloads/
- Vendor-specific support dates: https://www.oracle.com/java/technologies/java-se-support-roadmap.html

The skill installation contains no bundled support mapping; current official Oracle sources were used instead.
