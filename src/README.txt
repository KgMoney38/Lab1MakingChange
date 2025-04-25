//Design Patterns Implemented//

1. Strategy Pattern
Used to allow interchangeable change-making algorithms.
Implemented via the ChangeStrategy interface and GreedyChangeStrategy class.
Integrated into Register so the strategy can be swapped without changing its code.

2. Observer Pattern (Pull Model)
Used to automatically update the GUI when the Purse changes.
Implemented using the PurseObserver interface.
PursePanel implements this interface and pulls updates from Purse.

//Implementation Summary//

Interfaces added:

ChangeStrategy

PurseObserver

New classes:

GreedyChangeStrategy

DenominationFactory

Modified classes:

Register – now uses a ChangeStrategy

Purse – adds observer logic

PursePanel – observes Purse and refreshes display

RegisterPanel – wires everything together

https://github.com/KgMoney38/Lab1MakingChange