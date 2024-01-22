
# Thread Synchronization States in Java

## Thread States:

1. **WAITING State:**
   - All threads are waiting for others.
   - Releasing lock, going into WAITING state.

2. **Successful add/remove Operation:**
   - If the add/remove operation is successful, threads call `notifyAll()` and release the lock.

3. **BLOCKED State:**
   - Waiting threads, upon receiving a notification, go into BLOCKED state (Blocked for Lock).
   - They wait for the lock to become available.

![image](https://github.com/pushpak-256/MultiThreading-Tutorial/assets/70573212/fcf02bb1-98b5-4651-ac57-f138c802d95b)
