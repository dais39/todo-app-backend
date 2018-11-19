package com.dsuzuki.todoappbackend.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.junit.runner.RunWith

@RunWith(ArchUnitRunner::class)
@AnalyzeClasses(packages = ["com.dsuzuki.todoappbackend"])
class TestApplicationRules {

    @ArchTest
    fun applicationレイヤのクラスはpresentationレイヤ以外のクラスから依存されない(classes: JavaClasses) {

        val rules = ArchRuleDefinition.classes().that().resideInAPackage("..application..")
            .should().onlyBeAccessed().byClassesThat().resideInAPackage("..presentation..")

        rules.check(classes)
    }

    @ArchTest
    fun applicationレイヤのクラスはpresentationレイヤに依存しない(classes: JavaClasses){

        val rules = ArchRuleDefinition.noClasses().that().resideInAPackage("..application..")
            .should().accessClassesThat().resideInAPackage("..presentation..")

        rules.check(classes)
    }
}
