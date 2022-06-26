## Playwright-POC

---

- Done using:
- Playwright 1.20
- TestNG 7.6.0
- Assertj 3.23

### To install msedge on MacOS (having some difficulty installing edge on MacOS)

```shell script
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install msedge"
```
