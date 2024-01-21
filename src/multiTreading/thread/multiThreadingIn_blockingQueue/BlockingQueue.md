
- all Threads are waiting for other Threads, Releasing lock; going into WAITING state
- if add/remove operation is successfully performed Threads notifyAll() and release call
- Waiting Thread if gets a notification then it go into BLOCKED state (Blocked for Lock) and wait for lock

![image](https://github.com/pushpak-256/MultiThreading-Tutorial/assets/70573212/fcf02bb1-98b5-4651-ac57-f138c802d95b)
