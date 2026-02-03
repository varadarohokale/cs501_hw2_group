## Q1. What makes Compose declarative?
It means the UI is determined by state values, and whenever those values change, Compose recomputes the UI to match them automatically rather than how to transform it step-by-step.

## Q2. Where is state stored?
State is stored in the parent composable using remember. In our project, this composable owns the state and controls how the UI behaves. When the state changes, Compose automatically updates any UI that depends on it. Child composables, like CustomCard, do not store state themselves. They receive state as parameters and use callbacks to report changes back to the parent.

## Q3. Which composables are stateful vs. stateless?
The parent composable is stateful because it owns the state, while child composables are stateless because they only display state and send events upward. So, in our case **Dashboard Screen** is stateful & **CustomCard** is stateless.

## Q4. How does this differ from XML + View logic?
With XML and Views, UI layout and logic are separate, and thee UI has to be manually updated when the data changes. With Jetpack Compose, UI and logic are written together, and the UI updates automatically when state changes, which makes the code simpler and easier to follow.
