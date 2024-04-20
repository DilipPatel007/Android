# SMS Receiver Application Overview

This code implements an SMS receiver application that displays the sender number and message body on the screen. Let's break down how it works:

1. **MainActivity**:
   - `onCreate`: Called when the activity is first created.
     - `setContentView(R.layout.activity_main);`: Sets the layout file (`activity_main.xml`) for the activity.
     - `txtValues = findViewById(R.id.txtValues);`: Finds the `TextView` element with the ID `txtValues` from the layout and stores it in the `txtValues` variable.
   - `onStart`: Called when the activity becomes visible to the user.
     - Creates an `IntentFilter` to listen for intents with the action "update_message".
     - Registers a `BroadcastReceiver` named `messageReceiver` to handle intents matching the filter.
   - `onStop`: Called when the activity becomes invisible (e.g., minimized).
     - Unregisters the `messageReceiver` to avoid memory leaks.

2. **SmsReceiver**:
   - `onReceive`: Called when the `SmsReceiver` receives an SMS broadcast from the system.
     - Extracts the sender number and message body from the received SMS.
     - Logs the message details for debugging purposes.
     - Creates an update intent with the extracted information as extras.
     - Broadcasts the update intent to inform any registered receivers (in this case, the `messageReceiver` in `MainActivity`).

3. **Overall Flow**:
   - When a new SMS is received, the system broadcasts an SMS intent containing the SMS data.
   - The `SmsReceiver` processes the PDUs to extract the sender number and message body.
   - The `SmsReceiver` creates an update intent with the extracted information and broadcasts it with the action "update_message".
   - The registered `messageReceiver` in `MainActivity` receives the update intent, extracts the sender number and message, and calls `updateTextView` to update the UI with the received information.

