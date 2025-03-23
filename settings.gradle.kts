rootProject.name = "hexagonal_multi_module_practice"

include(
        "monolithic-client",
        "common"
)

project(":monolithic-client").projectDir = file("monolithic/client-api")

apply(from ="core/core.settings.gradle.kts")
apply(from ="services/board/board.settings.gradle.kts")
