# RapidResponse Dispatch — Starter Project

Starter repository for the COSC 2336 lab: Choosing the Right Data Structure.

## What's here

```
rapidresponse-starter/
├── .github/workflows/      # GitHub Actions CI (builds and tests on every push)
├── data/                   # CSV inputs and the expected output for the C3 diff
├── src/main/java/...       # production code: Dispatch, interfaces, stubs, CsvLoader
├── src/test/java/...       # JUnit 5 tests (one sample; you add the rest)
└── pom.xml                 # Maven build (JUnit 5, JaCoCo, -Xlint:all pre-configured)
```

## Prerequisites

- **Java 17+** — verify with `java -version`
- **Maven 3.8+** — verify with `mvn -version`
- An IDE (see below)

## Build, run, test

```bash
mvn clean verify
# -> compiles, runs tests, produces coverage report at target/site/jacoco/index.html

mvn package
java -cp target/classes edu.epcc.cosc2336.Dispatch
# -> default inputs: data/roads.csv data/units.csv data/calls.csv

# For the C3 verification step:
java -cp target/classes edu.epcc.cosc2336.Dispatch \
     data/roads.csv data/units.csv data/calls_small.csv > my_output.txt
diff data/expected_output.txt my_output.txt
```

An empty `diff` means your program matches expected output.

## IDE setup

**IntelliJ IDEA Community (recommended):** `File → Open → select this folder`. IntelliJ detects `pom.xml`, imports dependencies, and runs JUnit tests out of the box. The debugger is built in.

**VS Code:** install Microsoft's **Extension Pack for Java**, then open this folder. VS Code will pick up Maven, compile, and let you run tests via the Testing panel. Make sure JDK 17 is selected (`Java: Configure Java Runtime`).

Either IDE works for this lab. If you don't already have a strong IDE preference, use IntelliJ — Maven, JUnit, and the debugger need zero configuration.

## What you need to implement

Fill in the three stubs under `src/main/java/edu/epcc/cosc2336/impl/`:

| File | What |
|---|---|
| `CallQueueImpl.java` | Binary max-heap of `Call`; tie-break ties on severity by earlier arrival time |
| `UnitTableImpl.java` | Hash table with your choice of collision strategy; resize when load factor > 0.75 |
| `RoadNetworkImpl.java` | Adjacency list + Dijkstra's shortest path; respect one-way roads |

And complete the dispatch loop in `Dispatch.java` (look for the TODO). Each stub has a class-level comment with suggested fields and helpers — read them before you start coding.

## Output format for `Dispatch`

One line per dispatched call, printed to standard output:

```
CALL=<call_id> UNIT=<unit_id> ROUTE=<n1->n2->...->nK> TIME=<minutes to 2 decimals>
```

Example line (printed using `%.2f` for the time):

```
CALL=C-001 UNIT=PAT-001 ROUTE=6->7->9 TIME=3.50
```

`data/expected_output.txt` was produced from `data/calls_small.csv` using exactly this format. The small scenario is designed to have no ties in nearest-unit distance, so your output is deterministic once your data structures are correct.

## Data files

| File | Rows | What |
|---|---|---|
| `roads.csv` | 15 | Weighted road segments (one-way marked `Y`) |
| `units.csv` | 6 | Response units with station and status |
| `calls.csv` | 20 | Full call log for the real dispatch run |
| `calls_small.csv` | 3 | Tiny deterministic call list for the C3 diff check |
| `expected_output.txt` | 3 | Expected `Dispatch` output on `calls_small.csv` |

## Continuous integration

A GitHub Actions workflow (`.github/workflows/ci.yml`) runs `mvn clean verify` on every push and pull request. Once you push to your repository, check the **Actions** tab — a green check next to your latest commit means your build and tests passed in a clean Linux environment. The JaCoCo coverage report is uploaded as a workflow artifact you can download.

## Git workflow reminders

- Add the instructor as a collaborator on your private repo
- One feature branch per subproblem: `feature/triage`, `feature/units`, `feature/routing`
- Merge each branch into your own `main` via a pull request (3 PRs total)
- 8+ meaningful commits across the two weeks — not one dump at the end
- `mvn clean verify` must pass from a fresh clone before you submit

## AI assistant disclosure

If you used an AI assistant on any part of this lab, note what you used it for here and be prepared to explain every line of code during an optional walkthrough.
