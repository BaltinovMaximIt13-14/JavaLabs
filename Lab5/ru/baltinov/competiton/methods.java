package ru.baltinov.competiton;

import java.io.*;
import java.util.*;

public class methods {
  public static List<Participant> readParticipantsFromFile(String fileName) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(fileName));
    int n = scanner.nextInt();
    scanner.nextLine();

    List<Participant> participants = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      String[] parts = line.split("\\s+", 6);

      String surname = parts[0];
      String name = parts[1];
      int[] scores = new int[4];
      for (int j = 0; j < 4; j++) {
        scores[j] = Integer.parseInt(parts[2 + j]);
      }

      participants.add(new Participant(surname, name, scores));
    }

    scanner.close();
    return participants;
  }

  public static TreeMap<Integer, List<Participant>> fillScoreMap(List<Participant> participants) {
    TreeMap<Integer, List<Participant>> scoreMap = new TreeMap<>(Collections.reverseOrder());

    for (Participant p : participants) {
      int total = p.getTotalScore();
      scoreMap.computeIfAbsent(total, k -> new ArrayList<>()).add(p);
    }

    return scoreMap;
  }
  public static void printWinners(TreeMap<Integer, List<Participant>> scoreMap) {
    System.out.println("Лучшие участники:");
    int rank = 0;
    int lastScore = -1;
    boolean finished = false;

    for (Map.Entry<Integer, List<Participant>> entry : scoreMap.entrySet()) {
      if (finished) break;

      int currentScore = entry.getKey();
      List<Participant> participants = entry.getValue();

      if (rank < 3) {
        for (Participant p : participants) {
          System.out.println(currentScore + ": " + p);
          rank++;
          if (rank == 3) {
            lastScore = currentScore;
            break;
          }
        }
      }

      if (rank == 3 && currentScore == lastScore) {
        for (int i = 1; i < participants.size(); i++) {
          Participant p = participants.get(i);
          System.out.println(currentScore + ": " + p);

        }
      } else if (rank >= 3 && currentScore != lastScore) {
        finished = true;
      }
    }
  }
}
