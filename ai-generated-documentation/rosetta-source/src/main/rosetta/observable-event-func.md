![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
## Documentation for observable-event-func.rosetta

**1. Overview:**

This Rosetta code file defines functions related to asset payout trades and observations within a financial system. It focuses on attaching observations to security finance transactions and calculating reset values for equity payouts. 

**2. Package/module name:** cdm.observable.event

**3. Class/file name:** observable-event-func.rosetta

**4. Detailed Documentation:**

   - **`Create_AssetPayoutTradeStateWithObservations` Function:**
     - **Description:** This function attaches a set of observations to a Security Finance Transaction, creating a `TradeState` object. 
     - **Parameters:**
       - `billingInstruction`: A `BillingRecordInstruction` object representing the billing instruction for the transaction. (1..1)
     - **Return Values:**
       - `tradeState`: A `TradeState` object containing the updated state of the trade with attached observations. (1..1)
     - **Important Logic:**
       - Uses aliases to simplify references to specific data within the input `billingInstruction`.
       - Calls the `Create_AssetReset` function to generate a `Reset` object based on the provided observations and date.

   - **`Create_AssetReset` Function:**
     - **Description:** This function defines how to resolve the reset value for an equity payout, using provided observations and a specified date.
     - **Parameters:**
       - `assetPayout`: An `AssetPayout` object representing the payout to which the reset applies. (1..1)
       - `observation`: A collection of `Observation` objects used to calculate the reset value. (1..*)
       - `resetDate`: A `date` object specifying the date of the reset. (1..1)
     - **Return Values:**
       - `reset`: A `Reset` object containing the calculated reset value and associated information. (1..1)
     - **Important Logic:**
       - Calls `ResolveObservationAverage` to calculate the average observed value from the provided observations.
       - Assigns the calculated average as the `resetValue`.
       - Sets the `resetDate` and assigns the observation data for auditing purposes.

   - **`ResolveObservationAverage` Function:**
     - **Description:** This function provides an interface for resolving a single observation value from multiple observations, applying the specified averaging method.
     - **Parameters:**
       - `observations`: A collection of `Observation` objects to be averaged. (1..*)
     - **Return Values:**
       - `resetValue`: A `Price` object representing the calculated average value. (1..1)
     - **Important Logic:**
       - Checks if all observations have matching units before calculating the average.
       - Calculates the sum of observed values and divides by the number of observations to get the average.
       - Sets the `resetValue` with the calculated average, unit, perUnitOf, priceExpression, and priceType from the first observation.

**5. Pseudo Code:**


```
// Function: Create_AssetPayoutTradeStateWithObservations(billingInstruction)
  1. Set tradeState to billingInstruction -> tradeState
  2. Add resetHistory to tradeState 
    - Call Create_AssetReset(assetPayout, billingInstruction -> observation, date)

// Function: Create_AssetReset(assetPayout, observation, resetDate)
  1. Set reset -> resetValue: ResolveObservationAverage(observation)
  2. Set reset -> resetDate: resetDate
  3. Add observations to reset -> observations
    - Assign each observation from the input list
  4. Set reset -> averagingMethodology -> averagingMethod -> calculationMethod: AveragingCalculationMethodEnum -> Arithmetic

// Function: ResolveObservationAverage(observations)
  1. Get firstObservedValue from observations -> observedValue
  2. Check if all observations have matching units (UnitsMatch condition)
    - If not, throw an exception or handle the mismatch appropriately
  3. Calculate average value: sum of all observed values / number of observations
  4. Set resetValue -> value: calculated average value
  5. Set resetValue -> unit: firstObservedValue -> unit
  6. Set resetValue -> perUnitOf: firstObservedValue -> perUnitOf
  7. Set resetValue -> priceExpression: firstObservedValue -> priceExpression
  8. Set resetValue -> priceType: firstObservedValue -> priceType



```

**Dependencies and Libraries:**


- The code relies on several internal modules within the `cdm` namespace, such as `cdm.base.math`, `cdm.event.common`, `cdm.observable.asset`, and `cdm.product.template`. These likely represent core components of a larger financial system or data model.
-  The code uses specific enumeration types like `AveragingCalculationMethodEnum` which suggests the use of an internal library for defining and managing these enumerations.



**Edge Cases and Error Handling:**

- The pseudocode highlights potential edge cases:
    - **Units mismatch**: If observations have different units, the `ResolveObservationAverage` function checks for this condition and might throw an exception or handle it differently based on the system's requirements. 


-  The code likely includes more detailed error handling within its implementation, which is not captured in the provided Rosetta format.



