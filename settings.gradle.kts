rootProject.name = "hexagonal_multi_module_practice"

include(
        "monolithic",
        "common",
        "core:nettee-jpa-core",
        "services:board")

findProject(":core:nettee-jpa-core")?.name = "nettee-jpa-core"
findProject(":services:board")?.name = "board"
findProject(":common")?.name = "common"