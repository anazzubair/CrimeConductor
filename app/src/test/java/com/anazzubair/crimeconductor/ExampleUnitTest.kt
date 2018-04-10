package com.anazzubair.crimeconductor

import org.junit.Test

import org.junit.Assert.*
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import io.reactivex.SingleEmitter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    data class Todo(val name:String)
    fun getTodos():List<Todo> {
        return mutableListOf<Todo>(Todo("One"), Todo("Two"), Todo("Three"))
    }

    @Test fun unitTestingWorks() {
        val todoObservable = Observable.create({ emitter: ObservableEmitter<Todo> ->
            try {
                val todos = getTodos()
                for (todo in todos) {
                    emitter.onNext(todo)
                }
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        })

        todoObservable.subscribe { item -> System.out.println(item.name) }
    }

    @Test
    fun returnAValue() {
        var result = ""
        val observer = Observable.fromIterable(getTodos())
        observer.subscribe { item -> System.out.println(item.name) } // Callable as subscriber

    }

    @Test fun singleTodoList() {
        val todoSingle: Single<List<Todo>> = Single.create { emitter: SingleEmitter<List<Todo>> ->
            Thread {
                try {
                    val todosFromWeb: List<Todo> = getTodos()
                    System.out.println("Called many times")
                    emitter.onSuccess(todosFromWeb)
                } catch (e: Exception) {
                    emitter.onError(e)
                }
            }.start()
        }.cache()

        todoSingle.subscribe { _ -> System.out.println("SOne") }
        todoSingle.subscribe { _ -> System.out.println("STwpne") }
    }
}