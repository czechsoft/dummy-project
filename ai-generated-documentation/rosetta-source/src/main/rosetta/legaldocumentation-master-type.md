![Capgemini Logo](https://www.capgemini.com/wp-content/themes/capgemini2020/assets/images/logo.svg)

### Get The Future You Want!

---
## Legal Documentation - Master Agreement Concepts

**1. Overview:**

This code defines a schema for representing master agreement concepts within a financial domain. It utilizes data types to model clauses, variants, variables, and elections associated with different master agreement types like GMSLA, GMRA, and ISDA Master Agreements. The schema aims to provide a structured representation of these agreements, enabling easier analysis, comparison, and management.

**2. Package/Module Name:**

`cdm.legaldocumentation.master`

**3. Class/File Name:**

`MasterAgreementSchedule`, `MasterAgreementClause`, `MasterAgreementClauseVariant`, `MasterAgreementVariableSet`, `MasterAgreementBase`, `MasterAgreementElections`

**4. Detailed Documentation:**


* **Type: MasterAgreementSchedule**
    - **Description:** Represents the set of elections that specify a Master Agreement. 
    - **Parameters:** None
    - **Return Values:** None
    - **Important Logic:**  Contains an array of `MasterAgreementClause` objects, indicating the clauses included in the master agreement.

* **Type: MasterAgreementClause**
    - **Description:** Defines individual clauses that constitute a Master Agreement.
    - **Parameters:** None
    - **Return Values:** None
    - **Important Logic:**  Includes identifiers, names, counterparty roles, other party roles, and an array of `MasterAgreementClauseVariant` objects to define different variants for the clause.

* **Type: MasterAgreementClauseVariant**
    - **Description:** Sets the details for a specific variant associated with a clause in a Master Agreement.
    - **Parameters:** None
    - **Return Values:** None
    - **Important Logic:**  Contains identifiers, names, counterparty roles, other party roles, and an array of `MasterAgreementVariableSet` objects to define additional variables specific to this variant.

* **Type: MasterAgreementVariableSet**
    - **Description:** Defines a type where additional variables associated with clauses and their variants can be described. Allows for nested variable sets.
    - **Parameters:** None
    - **Return Values:** None
    - **Important Logic:**  Includes conditions to ensure proper nesting and the presence of both name and value pairs for variables.

* **Type: MasterAgreementBase**
    - **Description:** A set of shared elections that can be used as a base for specific master agreement types.
    - **Parameters:** None
    - **Return Values:** None
    - **Important Logic:**  Provides a foundation for defining more specialized master agreements by inheriting and extending these shared elections.

* **Type: MasterAgreementElections**
    - **Description:** Represents a master agreement extended from a base agreement of shared elections. Allows for specifying different types of master agreements (GMSLA, GMRA, ISDA).
    - **Parameters:** None
    - **Return Values:** None
    - **Important Logic:**  Uses one-of conditions to ensure that only one type of master agreement is specified (GMSLA, GMRA, or ISDA).

**5. Pseudo Code:**



```
// Class: MasterAgreementSchedule
function createMasterAgreementSchedule():
  1. Create a new instance of the MasterAgreementSchedule object.
  2. Initialize an empty array to store clauses.
  3. Return the newly created MasterAgreementSchedule object.

function addClause(clause):
  1. Check if the clause is valid (e.g., has a unique identifier).
  2. Add the clause to the array of clauses in the MasterAgreementSchedule object.

// Class: MasterAgreementClause
function createMasterAgreementClause():
  1. Create a new instance of the MasterAgreementClause object.
  2. Set default values for parameters (e.g., name, counterparty role).
  3. Initialize an empty array to store variants.
  4. Return the newly created MasterAgreementClause object.

function addVariant(variant):
  1. Check if the variant is valid (e.g., has a unique identifier).
  2. Add the variant to the array of variants in the MasterAgreementClause object.

// Class: MasterAgreementClauseVariant
function createMasterAgreementClauseVariant():
  1. Create a new instance of the MasterAgreementClauseVariant object.
  2. Set default values for parameters (e.g., name, counterparty role).
  3. Initialize an empty array to store variable sets.
  4. Return the newly created MasterAgreementClauseVariant object.

function addVariableSet(variableSet):
  1. Check if the variable set is valid (e.g., has a unique identifier and name/value pairs).
  2. Add the variable set to the array of variable sets in the MasterAgreementClauseVariant object.



// Class: MasterAgreementVariableSet
function createMasterAgreementVariableSet():
  1. Create a new instance of the MasterAgreementVariableSet object.
  2. Set default values for parameters (e.g., name, value).
  3. Return the newly created MasterAgreementVariableSet object.

// Class: MasterAgreementBase
function createMasterAgreementBase():
  1. Create a new instance of the MasterAgreementBase object.
  2. Initialize shared elections (e.g., default terms and conditions).
  3. Return the newly created MasterAgreementBase object.

// Class: MasterAgreementElections
function createMasterAgreementElections(agreementType):
  1. Check if agreementType is valid (GMSLA, GMRA, or ISDA).
  2. Create a new instance of the MasterAgreementElections object.
  3. Based on agreementType, initialize the corresponding election fields (e.g., islaGmsla, icmaGmra, isdaMaster).
  4. Return the newly created MasterAgreementElections object.



```

**6. Dependencies and Libraries:**


* The code relies on other modules within the `cdm` namespace for data types like `PartyRoleEnum`, `CounterpartyRoleEnum`, etc. These likely represent standard industry definitions or conventions. 
* No specific programming language libraries are directly used in this schema definition.



