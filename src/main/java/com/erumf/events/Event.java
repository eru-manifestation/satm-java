// package com.erumf.events;

// import java.util.ArrayList;
// import java.util.EventListener;
// import java.util.List;

// public abstract class Event {
//     // private boolean active;
//     private State state;
//     private final String reason;
//     private final Event position;
//     private static List<EventListener> inListeners = new ArrayList<>();
//     private static List<EventListener> execListeners = new ArrayList<>();
//     private static List<EventListener> outListeners = new ArrayList<>();

//     public enum State {
//         IN, IN_HOLD, EXEC, EXEC_HOLD, OUT, OUT_HOLD, DONE, DEFUSED
//     }

//     public Event(String reason, Event position) {
//         // this.active = false;
//         this.state = State.IN;
//         this.reason = reason;
//         this.position = position;
//         if (position != null) {
//             position.hold();
//         }
//         if (sendIn() && sendExec() && sendOut())
//             this.state = State.DONE;
//         else
//             this.state = State.DEFUSED;
//     }

//     // public boolean isActive() {
//     //     return active;
//     // }

//     // public void setActive(boolean active) {
//     //     this.active = active;
//     // }

//     public State getState() {
//         return state;
//     }

//     public String getReason() {
//         return reason;
//     }

//     public Object getPosition() {
//         return position;
//     }

//     public void hold() {
//         switch (this.state) {
//             case IN:
//                 this.state = State.IN_HOLD;
//                 break;
//             case EXEC:
//                 this.state = State.EXEC_HOLD;
//                 break;
//             case OUT:
//                 this.state = State.OUT_HOLD;
//                 break;
//             default:
//                 throw new IllegalStateException("Cannot hold event in state " + this.state);
//         }
//     }

//     // Add an event listener
//     public static void addEventListener(EventListener listener) {
//         inListeners.add(listener);
//     }

//     // Add an event listener
//     public static void execEventListener(EventListener listener) {
//         inListeners.add(listener);
//     }

//     // Add an event listener
//     public static void outEventListener(EventListener listener) {
//         inListeners.add(listener);
//     }

//     private boolean sendIn() {
//         inListeners.forEach(listener -> listener.onEvent(this));
//         // Implement the logic for sending the event in
//         return true; // Placeholder return value
//     }

//     private boolean sendExec() {
//         // Implement the logic for executing the event
//         return true; // Placeholder return value
//     }

//     private boolean sendOut() {
//         // Implement the logic for sending the event out
//         return true; // Placeholder return value
//     }

    
// }
