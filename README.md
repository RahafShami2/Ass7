#4. Explain why the logger uses a singleton design pattern.

If you are writing on a file system, having more than one instance (and therefore, probably, more than one thread) may result in a garbled file.
In the sense that depending on buffering and other low-level mechanisms messages from one write may end up mixed with messages (or parts of messages) from others.
If you wouldn't use a singleton class you would have to deal with the synchronization (writing to a file, or whatever stream you use) between these different logger instances. So its much easier, when you just have one global Logger instance.
