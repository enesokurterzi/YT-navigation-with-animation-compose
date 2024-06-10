package com.example.navigationwithanimationcompose

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ScreenOne) {
        composable<Screen.ScreenOne>(
            enterTransition = ::slideInToRight,
            exitTransition = ::slideOutToLeft
        ) {
            ScreenOne(navController = navController)
        }
        composable<Screen.ScreenTwo>(
            enterTransition = ::slideInToLeft,
            exitTransition = ::slideOutToLeft,
            popEnterTransition = ::slideInToRight,
            popExitTransition = ::slideOutToRight
        ) {navBackStackEntry ->
            val args: Screen.ScreenTwo = navBackStackEntry.toRoute()
            ScreenTwo(navController = navController, name = args.name, surname = args.surname)
        }
        composable<Screen.ScreenThree>(
            enterTransition = ::slideInToLeft,
            exitTransition = ::slideOutToRight
        ) {navBackStackEntry ->
            val args: Screen.ScreenThree = navBackStackEntry.toRoute()
            ScreenThree(navController = navController, title = args.title)
        }
    }
}

fun slideInToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(300)
    )
}

fun slideInToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(300)
    )
}

fun slideOutToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(300)
    )
}

fun slideOutToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(300)
    )
}