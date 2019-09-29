package edu.governnet.core.governetCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommitteeHelper {
    List<String> committeeFile;
    List<Committee> committeeList = new ArrayList<>();


    public CommitteeHelper(List<String> committeeList) {
        this.committeeFile = committeeList;
    }

    public void buildCommitteesFromFile(){
        for (String committeeInfo : committeeFile) {
            String[] committeeInfoFields = committeeInfo.split("\\|", -1);

            List<String> committeesProcessed = Arrays.stream(committeeInfoFields)
                    .map(field -> field.trim())
                    .collect(Collectors.toList());

            Committee committee = new Committee.CommitteeBuilder()
                    .committeeId(committeesProcessed.get(0))
                    .committeeName(committeesProcessed.get(1))
                    .treasurerName(committeesProcessed.get(2))
                    .streetOne(committeesProcessed.get(3))
                    .streetTwo(committeesProcessed.get(4))
                    .cityOrTown(committeesProcessed.get(5))
                    .state(committeesProcessed.get(6))
                    .zip(committeesProcessed.get(7))
                    .committeeDesignation(committeesProcessed.get(8))
                    .committeeType(committeesProcessed.get(9))
                    .committeeParty(committeesProcessed.get(10))
                    .filingFrequency(committeesProcessed.get(11))
                    .organizationType(committeesProcessed.get(12))
                    .organizationName(committeesProcessed.get(13))
                    .candidateId(committeesProcessed.get(14))
                    .createCommittee();

            committeeList.add(committee);
        }
    }

    public List<Committee> getCommitteeList() {
        return committeeList;
    }
}