import QueueLinkedList from "./QueueLinkedList";

describe("QueueLinkedList", () => {
  let queueLinkedList;
  beforeEach(() => {
    queueLinkedList = new QueueLinkedList();
  });

  describe("isEmpty", () => {
    it("on init", () => {
      expect(queueLinkedList.isEmpty()).toEqual(true);
    });

    it("is false after a enqueue operation", () => {
      queueLinkedList.enqueue("foo");
      expect(queueLinkedList.isEmpty()).toEqual(false);
    });
  });

  describe("Integration", () => {
    it("verifies the end state", () => {
      queueLinkedList.enqueue("to");
      queueLinkedList.enqueue("be");
      queueLinkedList.enqueue("or");
      queueLinkedList.enqueue("not");
      queueLinkedList.enqueue("to");
      expect(queueLinkedList.dequeue()).toEqual("to");
      queueLinkedList.enqueue("be");
      expect(queueLinkedList.dequeue()).toEqual("be");
      expect(queueLinkedList.dequeue()).toEqual("or");
      queueLinkedList.enqueue("that");
      expect(queueLinkedList.dequeue()).toEqual("not");
      expect(queueLinkedList.dequeue()).toEqual("to");
      expect(queueLinkedList.dequeue()).toEqual("be");
      queueLinkedList.enqueue("is");
    });
  });
});
