# Calculator Application
## Overview
This is a simple calculator application designed to perform basic arithmetic operations (addition, subtraction, multiplication, and division) using a strategy pattern for extensibility and maintainability.

<img width="1000" alt="image" src="https://github.com/rashmislr30/springboot-calculator-app/blob/bcec75c93bb163dde562ededbab6e74ada5271c5/assets/diagram.png">

## Architecture
The application follows a layered architecture consisting of the following components:

1. **Controller**: Manages user input and interacts with the service layer.
2. **Service**: Contains business logic and communicates with the StrategyFactory.
3. **Domain**: Defines the operation types (Add, Subtract, Multiply, Divide) using an enum.
4. **Model**: Represents data structures for operations and numbers.
5. **Exception**: Manages exceptions related to unsupported operations or number types.
6. **Strategy**: Implements specific strategies for each operation (e.g., `DoubleAddOperation`, `IntegerMulOperation`).

## Design Decisions
- **Strategy Pattern**: The Strategy Pattern was chosen to allow flexibility in adding new operations without modifying existing code. Each operation has its own class that implements the `OperationStrategy` interface, enabling easy extension.
- **Factory Pattern**: The Factory Pattern was chosen to simplify the selection of appropriate strategies. Instead of having complex `if-else` logic within the service layer, the factory is responsible for determining which operation strategy to use.
- **Builder Pattern**: The Builder Pattern was introduced to structure the response object in the controller. It provides a flexible way to manage response creation, ensuring that the response is immutable and easy to extend.
- **Logging**: Lombok's `@Slf4j` is used for logging operations and unsupported types to assist in debugging and provide better visibility into the application's behavior.
- **Enum for Operations**: An enum is used to define operations, making it easy to manage and extend the available operations.

## Getting Started
### Prerequisites
- Java 11 or higher
- Maven (for dependency management)
- Spring 3.x
- JUnit
- Log4j2

## Calculate - Sample Requests

curl --location 'http://localhost:9091/v1/calculator/calculate' \
--header 'Content-Type: application/json' \
--data '
{
"operation": "DIVIDE",
"num1": 15.5,
"num2": 3.0
}
'

## Chain Calculate - Sample Requests

curl --location 'http://localhost:9092/v1/calculator/chain' \
--header 'Content-Type: application/json' \
--data '{
"init_value": 10,
"operations": [
{
"op": "ADD",
"num": 5
},
{
"op": "MULTIPLY",
"num": 3
},
{
"op": "DIVIDE",
"num": 2
}
]
}
'
## Future Improvements
- Support for more Operators and Numeric Types.
- Expand the calculator to handle more operations (like mod, square root) and support more numeric types (e.g., `BigDecimal`).
- Resiliency (Rate Limiting, Retries, Multithreading)