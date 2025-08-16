class Foo:
    def __init__(self):
        self.first_event = threading.Event()
        self.second_event = threading.Event()
        pass


    def first(self, printFirst: 'Callable[[], None]') -> None:
        
        # printFirst() outputs "first". Do not change or remove this line.
        printFirst()

        # Set the first_event event after we are done printing the first
        self.first_event.set()


    def second(self, printSecond: 'Callable[[], None]') -> None:
        # Wait for the first to finish
        self.first_event.wait()

        # printSecond() outputs "second". Do not change or remove this line.
        printSecond()

        # Set the second_event event after we are event printing the second
        self.second_event.set()


    def third(self, printThird: 'Callable[[], None]') -> None:
        # Wait for the second to finish
        self.second_event.wait()

        # printThird() outputs "third". Do not change or remove this line.
        printThird()
